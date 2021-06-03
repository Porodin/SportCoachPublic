import { loadingSuggestedProductAndCategories } from '@root-store/selectors/category.selectors';
import { ICategoryState } from '@root-store/reducers/categories.reducer';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { Observable } from 'rxjs';
import { getCategoriesPending } from '@root-store/actions/category.actions';
import { ICategory } from '@root-store/reducers/categories.reducer';
import { IStore } from '@root-store/reducers';
import { Store } from '@ngrx/store';
import {
  getSuggestedProductsPending,
  clearSuggestedProducts,
} from './store/actions/suggested-products.actions';
import { UnSubscriber } from '@shared/utils/unsubscriber';
import { takeUntil } from 'rxjs/operators';
import { FormBuilder, FormGroup } from '@angular/forms';
import { IBanner } from './banner/banner.component';
import { IProductsState } from '@category-store/reducers/products.reducer';

@Component({
  selector: 'sport-coach-products',
  templateUrl: './home.component.html',
})
export class HomeComponent extends UnSubscriber implements OnInit, OnDestroy {
  public categories: ICategory[] = [];
  public categories$: Observable<ICategoryState> = this._store
    .select('categories')
    .pipe(takeUntil(this.unsubscribe$$));
  public products$: Observable<IProductsState> = this._store
    .select('suggestedProducts')
    .pipe(takeUntil(this.unsubscribe$$));
  public form: FormGroup = this._fb.group({
    currentSubCategory: [''],
  });
  public loading$: Observable<boolean> = this._store.select(
    loadingSuggestedProductAndCategories
  );
  public bannerItems: IBanner[] = [
    {
      subCategoryId: 'grifi i ganteli',
      title: 'Инвентарь для занятий с железом',
      image: '/assets/images/barrel.png',
    },
    {
      subCategoryId: 'crossfit',
      title: 'Инвентарь для кроссфита',
      image: '/assets/images/crossfit.jpg',
    },
    {
      subCategoryId: 'sportpit',
      title: ' спортивное питание',
      image: '/assets/images/sportpit.jpg',
    },
  ];

  constructor(
    private readonly _store: Store<IStore>,
    private readonly _fb: FormBuilder
  ) {
    super();
  }

  public ngOnInit(): void {
    this._store.dispatch(getCategoriesPending());
    this._store.dispatch(getSuggestedProductsPending());
  }
  public ngOnDestroy(): void {
    this._store.dispatch(clearSuggestedProducts());
  }
}
